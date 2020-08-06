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
package org.apache.cayenne.commitlog.model;

import java.util.Collection;
import java.util.Map;

import org.apache.cayenne.ObjectId;

/**
 * Represents a map of changes for a graph of persistent objects.
 * 
 * @since 4.0
 */
public interface ChangeMap {

	/**
	 * Returns a map of changes. Note the same change sometimes can be present
	 * in the map twice. If ObjectId of an object has changed during the commit,
	 * the change will be accessible by both pre-commit and post-commit ID. To
	 * get unique changes, call {@link #getUniqueChanges()}.
	 */
	Map<ObjectId, ? extends ObjectChange> getChanges();

	Collection<? extends ObjectChange> getUniqueChanges();
}
