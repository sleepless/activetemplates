/*
 * Copyright 2009 Anton Tanasenko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.code.activetemplates.impl.handlers;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.namespace.QName;


import com.google.code.activetemplates.events.AttributeHandler;
import com.google.code.activetemplates.events.ElementHandler;
import com.google.code.activetemplates.lib.attributes.IfAttr;
import com.google.code.activetemplates.lib.elements.Action;
import com.google.code.activetemplates.lib.elements.Container;
import com.google.code.activetemplates.lib.elements.Each;
import com.google.code.activetemplates.lib.elements.If;
import com.google.code.activetemplates.lib.elements.Nobr;
import com.google.code.activetemplates.spi.HandlerSPI;

public class DefaultHandlerSPI implements HandlerSPI {
    
    public static final String NAMESPACE_STDLIB = 
        "http://code.google.com/p/activetemplates/ns/stdlib";

    private static final Map<QName, AttributeHandler> attributes = new HashMap<QName, AttributeHandler>();
    private static final Map<QName, ElementHandler> elements = new HashMap<QName, ElementHandler>();
    private static final Set<String> excludedNamespaces = new HashSet<String>();
    
    static {
        elements.put(Action.ELEMENT, new Action());
        elements.put(Container.ELEMENT, new Container());
        elements.put(Each.ELEMENT, new Each());
        elements.put(If.ELEMENT, new If());
        elements.put(Nobr.ELEMENT, new Nobr());
        
        attributes.put(IfAttr.ATTRIBUTE, new IfAttr());
        
        excludedNamespaces.add(NAMESPACE_STDLIB);
    }

    public Map<QName, AttributeHandler> getAttributeHandlers() {
        return Collections.unmodifiableMap(attributes);
    }

    public Map<QName, ElementHandler> getElementHandlers() {
        return Collections.unmodifiableMap(elements);
    }

    public Set<String> getExcludedNamespaces() {
        return Collections.unmodifiableSet(excludedNamespaces);
    }
    
    public String getProvider(){
        return "default";
    }

}
