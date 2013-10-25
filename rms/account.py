import json
import rms
from bson.objectid import ObjectId
from flask import request as req

def get_db():
    return rms.app.data.driver.db

def add_credential_for_post(request, payload):
    j = json.loads(payload.data)
    _id = j['"account1"']['_id']
    user = rms.app.data.driver.db["account"].find_one({"_id": ObjectId(_id)})
    cred = create_credential(user['username'], user['password']);
    j['"account1"']['credential'] = cred.strip()
    payload.data = json.dumps(j)

def create_credential(name, pwd):
    if not name or not pwd:
        raise Exception("name or pwd can't be empty")
    cred = (name + ":" + pwd).encode("base64")
    return cred[:-1]

def get_one(username, password):
    users = list(rms.app.data.driver.db["super_user"].find()) + \
            list(rms.app.data.driver.db["operator"].find())
    for u in users:
        if username == u['name'] and password == u['password']:
            return u
    return None

def exists(name, pwd):
    return True if get_one(name, pwd) else False;

def update_super_user_id(request, payload):
    name, pwd = parse_username_and_password(request)
    print name, pwd
    one = get_db()['super_user'].find_one({'name': name, 'password': pwd})
    if one:
        super_id = one['_id']
        get_db()['operator'].update({'name': name}, {'$set': {'super_user_id': super_id}})

def parse_username_and_password(request):
    if request.headers.get('Authorization'):
        auth = request.headers['Authorization'].split()[1].decode('base64')
        return auth.split(':')

def parse_auth_field():
    username, pwd = parse_username_and_password(req)
    user = get_db().operators.find_one({'name': username})
    uid = None
    if user:
        uid = user['super_user_id']
    else: 
        user = get_db().super_user.find_one({'name': username})
        if user:
            uid = user['_id']
    return uid

def get_super_user_id(name, pwd):
    u = get_db()['super_user'].find_one({'name': name, 'password': pwd})
    if u:
        return str(u['_id'])
