package com.codecool.lms.service;

import com.codecool.lms.exception.UserAlreadyRegisteredException;
import com.codecool.lms.exception.UserNotFoundException;
import com.codecool.lms.exception.WrongPasswordException;
import com.codecool.lms.model.*;

import java.sql.SQLException;
import java.util.List;

interface UserService {

    List<User> getUsers() throws SQLException;

    boolean containsUser(String email) throws SQLException;

    void register(String name, String email, String password, String type) throws SQLException, UserAlreadyRegisteredException;

    User findUserByLoginData(String email, String password) throws WrongPasswordException, SQLException, UserNotFoundException;

    User findUserByName(String name) throws SQLException, UserNotFoundException;

    void addDay(String date, List<Student> students) throws SQLException;

    List<Day> getDays() throws SQLException;

    boolean dayExist(String date) throws SQLException;

    Day findDayByDate(String date) throws SQLException;

    void updateAttendance(String date, List<Student> students) throws SQLException;

    List<Student> getStudents();

    List<Student> createAttendStudentList(String[] studentNames) throws SQLException, UserNotFoundException;

    List<Repository> createRepositoryList(String[] htmls, String[] names, String[] stars, String[] watchers, String[] forks);

    GitHub createGithub(String avatar, String html, int repos, int gists, int followers, int following, String company, String blog, String location, String created, List<Repository> repositories);

    void connectUserWithGithub(User user, GitHub gitHub);

    void disconnectUserFromGithub(User user);

    User changeUserRole(User user, String type) throws SQLException, UserNotFoundException;

    User changeUserName(User user, String newName) throws SQLException, UserNotFoundException;

    User changeUserPassword(User user, String password) throws SQLException, UserNotFoundException;
}
