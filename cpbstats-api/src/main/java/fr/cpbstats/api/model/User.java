package fr.cpbstats.api.model;

import com.wordnik.swagger.annotations.ApiModel;

/**
 * The {@link User} class.
 * 
 * @author rebourgi
 *
 */
@ApiModel
public class User {

    /** The id. */
    private String id;

    /** The firstName. */
    private String firstName;

    /** The lastName. */
    private String lastName;

    /** The email. */
    private String email;

    /** The pictureSet. */
    private boolean pictureSet;

    /**
     * Return the UserApiModel id.
     * 
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Set the UserApiModel id.
     * 
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Return the UserApiModel firstName.
     * 
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the UserApiModel firstName.
     * 
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Return the UserApiModel lastName.
     * 
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the UserApiModel lastName.
     * 
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Return the UserApiModel email.
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the UserApiModel email.
     * 
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return the UserApiModel pictureSet.
     * 
     * @return the pictureSet
     */
    public boolean isPictureSet() {
        return pictureSet;
    }

    /**
     * Set the UserApiModel pictureSet.
     * 
     * @param pictureSet
     *            the pictureSet to set
     */
    public void setPictureSet(boolean pictureSet) {
        this.pictureSet = pictureSet;
    }

}
