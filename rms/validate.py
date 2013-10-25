#! /usr/bin/env python
# -*- coding: utf-8 -*-
# vim:fenc=utf-8
#
# Copyright © 2013 ccheng <ccheng@cchengs-MacBook-Air.local>
#
# Distributed under terms of the MIT license.
import rms
from bson import ObjectId

def validate(end, ids):
    if not ids:
        return
    imports = get_db()[end]
    ids = [ObjectId(x) for x in ids]
    imports.update({"_id": {"$in": ids}}, {"$set": {"validated": "1"}},multi=True)

def get_db():
    return rms.app.data.driver.db

