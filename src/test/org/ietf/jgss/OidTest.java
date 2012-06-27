package org.ietf.jgss;

import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;

import org.ietf.jgss.Oid;
import org.ietf.jgss.GSSException;

public class OidTest extends TestCase {

    public void testOidStringFail() throws GSSException {
        try {
            Oid testOid = new Oid("asdfasdf");
            fail("No exception was thrown");
        } catch (GSSException e) {
            // We expect to fail, proceed
        }
    }

    public void testOidStringPass() throws GSSException {
        try {
            Oid testOid = new Oid("1.2.3.4");
        } catch (GSSException e) {
            fail("new Oid(String) failed");
        }
    }

    public void testOidtoString() throws GSSException {
        String oidString = "1.2.840.113554.1.2.2"; 
        byte[] oidDER = {(byte)0x06, (byte)0x09, (byte)0x2A, (byte)0x86, 
                         (byte)0x48, (byte)0x86, (byte)0xF7, (byte)0x12, 
                         (byte)0x01, (byte)0x02, (byte)0x02};
        try {
            Oid testoid = new Oid("1.2.840.113554.1.2.2");
            if (!oidString.equals(testoid.toString())) {
                fail("Oid.toString failed");
            }

            Oid testoid2 = new Oid(oidDER);
            if (!oidString.equals(testoid2.toString())) {
                fail("Oid.toString failed using DER-encoded OID, " + testoid2.toString());
            }
        } catch (GSSException e) {
            throw e;
            //fail("Failed to create Oid object");
        }
    }
}