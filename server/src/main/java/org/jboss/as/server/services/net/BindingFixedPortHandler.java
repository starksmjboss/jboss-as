/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package org.jboss.as.server.services.net;

import org.jboss.as.controller.operations.validation.ModelTypeValidator;
import org.jboss.as.server.BootOperationHandler;
import org.jboss.dmr.ModelNode;
import org.jboss.dmr.ModelType;

/**
 * Handler for changing the fixed-port setting on a socket binding.
 *
 * @author Brian Stansberry (c) 2011 Red Hat Inc.
 */
public class BindingFixedPortHandler extends AbstractBindingWriteHandler implements BootOperationHandler {

    public static final BindingFixedPortHandler INSTANCE = new BindingFixedPortHandler();

    private BindingFixedPortHandler() {
        super(new ModelTypeValidator(ModelType.BOOLEAN, true, true));
    }

    @Override
    void handleRuntimeChange(ModelNode operation, String attributeName, ModelNode attributeValue, SocketBinding binding) {
        binding.setFixedPort(attributeValue.asBoolean());
    }
}
