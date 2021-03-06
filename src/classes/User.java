/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import structs.*;


/**
 * @author El Danilo (Daniel xd) y yo xd (Juan Eduardo)
 */
public class User {

    public String firstName;
    public String lastName;
    public String email;
    public String username;
    public String mobileNumber;
    public String password;
    public int wallet;
    // Implementar wallet
    //public LocalDate birthDate;
    public String birthDate;
    public String gender;
    public DynamicArray<String> ownProjectList = new DynamicArray<String>();
    public DynamicArray<String> followedProjects = new DynamicArray<String>();

//Poner todos los atributos en el constructor String FirstName, String LastName,
    public User(String FirstName, String LastName, String email, String username,
                String mobileNumber, String password, /*LocalDate*/ String birthDate, String gender) {
        this.firstName = FirstName;
        this.lastName = LastName;
        this.email = email;
        this.username = username;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.birthDate = birthDate;
        this.gender = gender;
        this.wallet = 0;
        //this.picture = ;
    }
    /*@RequiresApi(api = Build.VERSION_CODES.O)
    public User(EditText FirstName, EditText LastName, EditText email, EditText username,
                EditText mobileNumber, EditText password, EditText birthDate, Spinner gender) {
        this.firstName = FirstName.getText().toString();
        this.lastName = LastName.getText().toString();
        this.email = email.getText().toString();
        this.username = username.getText().toString();
        this.mobileNumber = mobileNumber.getText().toString();
        this.password = password.getText().toString();
        //this.birthDate = LocalDate.parse(birthDate.getText());
        this.birthDate = birthDate.getText().toString();
        this.gender = gender.getSelectedItem().toString();
    }*/

    /*public void setPicture(Uri picture) {
        this.picture = picture;
    }*/

    public User() {

    }


    public void followProject(Project project) {
        followedProjects.append(project.name);
        //project.followers.append(this.username);
    }

    public void createProject(String name, int bdgt, String ctgr, String dscpt) {
        Project newProject = new Project(name,this, bdgt, ctgr, dscpt);
        ownProjectList.append(newProject.name);
    }

    public boolean validateUsers(User userToValidate) {
        if (this.username.equals(userToValidate.username) && this.password.equals(userToValidate.password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String s = "Username: " + username + " Password: " + password + " Birthdate: " + birthDate + " Email: " + email
                + " Projects: " + ownProjectList.toString() + " Followed: " + followedProjects.toString();
        return s;
    }
}
