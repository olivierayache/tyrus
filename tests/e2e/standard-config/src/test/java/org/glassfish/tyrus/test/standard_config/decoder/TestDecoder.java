/*
 * Copyright (c) 2012, 2017 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package org.glassfish.tyrus.test.standard_config.decoder;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;

import org.glassfish.tyrus.core.coder.CoderAdapter;
import org.glassfish.tyrus.test.standard_config.message.TestMessage;

/**
 * Decoder for the TestMessage
 *
 * @author Stepan Kopriva (stepan.kopriva at oracle.com)
 */
public class TestDecoder extends CoderAdapter implements Decoder.Text<TestMessage> {
    @Override
    public TestMessage decode(String s) throws DecodeException {
        return new TestMessage(s.substring(TestMessage.PREFIX.length(), s.length()));
    }

    @Override
    public boolean willDecode(String s) {
        return s.startsWith(TestMessage.PREFIX);
    }
}
