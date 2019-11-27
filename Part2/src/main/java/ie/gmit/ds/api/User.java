package ie.gmit.ds.api;
// https://howtodoinjava.com/dropwizard/tutorial-and-hello-world-example/
// Adapted from https://github.com/john-french/artistAPI-dropwizard

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.protobuf.ByteString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User {
    @NotNull
    int userID;
    @NotBlank @Length(min = 2, max = 15)
    String password;
    //private static int userID;
    //@NotNull
   // int userID;
  //  @NotBlank
    @Length(min = 2, max = 15)
    String userName;
    @Pattern(regexp=".+@.+\\.[a-z]+")
    String email;
  //  @NotBlank @Length(min = 2, max = 15)
   // String password;


    private ByteString hashedPassword;
    private ByteString salt;



    // a no-argument constructor needed for Jackson deserialisation
    public User(){}

    // constructor that takes all 4 fields as arguments
    public User(int userID, String userName, String email, String password) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;

    }


    public User(int userID, String userName, String email, ByteString hashedPassword, ByteString salt) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
    }


    // getters for all  fields
    // @JsonProperty allows the class to be serialised/deserialised by Jackson.
    @JsonProperty
    public int getUserID() { return userID; }

    @JsonProperty
    public String getUserName() {
        return userName;
    }

    @JsonProperty
    public String getEmail() {
        return email;
    }

    @JsonProperty
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public ByteString getHashedPassword() { return hashedPassword; }

    @JsonProperty
    public ByteString getSalt() { return salt; }

    public String toString(){
        return "User{" +
                "User ID =" + userID +
                ", User Name ='" + userName + '\'' +
                ", E-mail ='" + email + '\'' +
                ", Password ='" + password + '\'' +
                ", Hashed Password=" + hashedPassword +
                ", Salt =" + salt + '}';
    }

}