package org.poc.pojo;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User: cam
 * Date: 2/04/14
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class LdapEndpoint {

    private static Logger log = LoggerFactory.getLogger(LdapEndpoint.class);
    private String domain;
    private String ldapHost;
    private String searchBase;
    private String bindUser;
    private String bindPassword;
    private String groupCN;

    public boolean search(String mobileNumber) {
        boolean isValidMobile = false;

        String returnedAtts[] = { "displayName", "mail", "mobile", "manager" };
        String searchFilter = "(&(objectClass=person)(memberOf=" + getGroupCN()
                + ")(mobile="
                + mobileNumber
                + "))";

        // Create the search controls
        SearchControls searchCtls = new SearchControls();
        searchCtls.setReturningAttributes(returnedAtts);

        // Specify the search scope
        searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, getLdapHost());
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, getBindUser() + "@" + getDomain());
        env.put(Context.SECURITY_CREDENTIALS, getBindPassword());
        LdapContext ctxGC = null;

        try {
            ctxGC = new InitialLdapContext(env, null);
            // Search objects in GC using filters
            NamingEnumeration<?> answer = ctxGC.search(getSearchBase(),
                    searchFilter, searchCtls);
            isValidMobile = answer.hasMoreElements();
        } catch (NamingException ex) {
            log.error("Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
        return isValidMobile;

    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getBindUser() {
        return bindUser;
    }

    public void setBindUser(String bindUser) {
        this.bindUser = bindUser;
    }

    public String getBindPassword() {
        return bindPassword;
    }

    public void setBindPassword(String bindPassword) {
        this.bindPassword = bindPassword;
    }

    public String getLdapHost() {
        return ldapHost;
    }

    public void setLdapHost(String ldapHost) {
        this.ldapHost = ldapHost;
    }

    public String getSearchBase() {
        return searchBase;
    }

    public void setSearchBase(String searchBase) {
        this.searchBase = searchBase;
    }

    public String getGroupCN() {
        return groupCN;
    }

    public void setGroupCN(String groupCN) {
        this.groupCN = groupCN;
    }
}
