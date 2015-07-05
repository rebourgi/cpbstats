package fr.cpbstats.api.model;

import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;

/**
 * The {@link UserGroup} class.
 * 
 * @author rebourgi
 *
 */
@ApiModel
public class UserGroup {

    /** The username. */
    private String username;

    /** The groups. */
    private List<String> groups;

    /**
     * Return the UserGroupApiModel username.
     * 
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the UserGroupApiModel username.
     * 
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Return the UserGroupApiModel groups.
     * 
     * @return the groups
     */
    public List<String> getGroups() {
        return groups;
    }

    /**
     * Set the UserGroupApiModel groups.
     * 
     * @param groups
     *            the groups to set
     */
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

}
