#! /usr/bin/env python
# -*- coding: utf-8 -*-
# vim:fenc=utf-8
#
# Copyright © 2013 ccheng <ccheng@cchengs-MacBook-Air.local>
#
# Distributed under terms of the MIT license.

"""

"""

import rms
import account

def get_db():
    return rms.app.data.driver.db

def insert_with_auth_field(collection, data):
    user_id = account.parse_auth_field()
    data['user_id'] = user_id
    collection.insert(data)
