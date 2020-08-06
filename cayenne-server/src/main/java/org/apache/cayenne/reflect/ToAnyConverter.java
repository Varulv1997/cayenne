/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/
package org.apache.cayenne.reflect;

import java.lang.reflect.Constructor;

import org.apache.cayenne.CayenneRuntimeException;

/**
 * Can convert to any class that has a constructor that takes a 
 * single Object or a single String parameter.
 */
public class ToAnyConverter<T> extends Converter<T> {
	@Override
	protected T convert(Object value, Class<T> type) {
		if (value == null) {
            return null;
        }
		if (type.isAssignableFrom(value.getClass())) {
            return (T) value; // no conversion needed
        }
		
        try {
            Constructor<?> constructor;
            try {
            	constructor = type.getConstructor(Object.class);
            } catch (NoSuchMethodException e) {
                constructor = type.getConstructor(String.class);
            	value = value.toString();
            }
            return (T) constructor.newInstance(value);
        } catch (Exception e) {
            throw new CayenneRuntimeException(e);
        }
	}
}