import * as App from './App.js';

(function (window, document, undefined) {
    window.onload = function () {
      
        let school = {
            name: "",
            description: "",
        }

        let subject = {
            name: "",
            description: "",
            school: 0,
            teacher: 0
        }

        //if path is login.html
        if (window.location.pathname.includes("login.html")) {
            const loginButton = document.getElementById('loginButton');

            loginButton.addEventListener('click', (event) => {
                event.preventDefault();
                let email = document.getElementById('email').value;
                let password = document.getElementById('password').value;

                const data = {
                    email: email,
                    password: password
                }
                App.login(data);
            });

        }

        
        if(window.location.pathname.includes("school-detail-form.html")){
             //Create a new school

        const createSchoolButton = document.getElementById('createSchool');

        createSchoolButton.addEventListener('click', (event) => {
            event.preventDefault();

            let name = document.getElementById('school').value;
            let description = document.getElementById('desc').value;

            // Get user data from the form
            let admin = document.getElementById('administrator').value;
            let email = document.getElementById('email').value;

            const user = {
                role: "TEACHER",
                name: admin,
                email: email,
            }

            school.name = name;
            school.description = description;

            App.createSchool(school);
            App.createUser(user);
        });
        }

        if (window.location.pathname.includes("school.html")) {
            // Get schools

            const schoolsSection = document.querySelector('.schools');
            schoolsSection.addEventListener('onload', (event) => {
                App.getSchools();
            });
        }

        if (window.location.pathname.includes("attendance.html")) {
            // Get attendance

            const studentsSection = document.querySelector('.attendances');
            studentsSection.addEventListener('onload', () => {
                App.getAttendances();
            });
        }

        if (window.location.pathname.includes("teachers.html")) {
            // Get teachers in a school

            const teachersSection = document.querySelector('.teachers');
            studentsSection.addEventListener('onload', () => {
                App.getUserByRole("TEACHER");
            });
        }

        if (window.location.pathname.includes("students.html")) {
            // Get students in a school

            const teachersSection = document.querySelector('.students');
            studentsSection.addEventListener('onload', () => {
                App.getUserByRole("STUDENT");
            });
        }

    }
})(window, document, undefined);