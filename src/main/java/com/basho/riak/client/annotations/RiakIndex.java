/*
 * This file is provided to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.basho.riak.client.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to declare a field or getter/setter pair as a RiakIndex.
 * <p>
 * You do not need to specify the index type prefix (_bin/_int). It will be
 * inferred from the type of the annotated field. 
 * 
 * Only String/Long/long or {@code Set<String>} / {@code Set<Long>}  fields
 * may be annotated with RiakIndex. 
 * </p>
 * <p>
 * <b>NOTE: if there are *multiple* values for the same named index and the field
 * in the domain object is an long, Long, or String only the 1st will find 
 * it's way into the domain object</b>
 * </p>
 * <p>
 * For example: 
 * </p>
 * <pre>
 * 
 * public class MyClass {
 *     &#064;RiakKey
 *     private String myKeyString;
 *     
 *     &#064;RiakIndex(name="email")
 *     private String emailAddress; // will be indexed in email_bin index
 *     
 *     &#064;RiakIndex(name="age")
 *     private long age; // will be index in age_int index
 * }
 *  
 * </pre>
 * 
 * 
 * 
 * @author russell
 * @see JSONConverter
 */
@Retention(RetentionPolicy.RUNTIME) @Target({ElementType.FIELD, ElementType.METHOD}) public @interface RiakIndex {
    /**
     * @return the index name
     */
    String name() default "";
}