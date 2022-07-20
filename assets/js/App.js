const BaseUrl = 'https://api.vschool.namani.co/api/v1';

export const checkLogin = () => {
    const token = localStorage.getItem('token');
    if (token) {
        // if user is Admin
        window.location.href = './dashboard.html';
        return;

        //if user is Teacher
        //TODO: Implement this
    }

    window.location.href = './login.html';
    return;
}

export const login = async (data) => {
    fetch(`${BaseUrl}/users/login`, {
        method: 'POST',
        body: JSON.stringify(data)
    })
        .then(res => res.status === 200 ? res.json() : { error: 'Invalid Credentials' })
        .then(res => {
            if (res.error) {
                alert(res.error);
                return;
            }
            localStorage.setItem('token', res.token);
            localStorage.setItem('user', JSON.stringify(res.user));
            window.location.href = './dashboard.html';
        })
        .catch(err => alert(err));
}

export const getUser = () => {

    const token = localStorage.getItem('token');
    let data;
    if (token) {
        data = fetch(`${BaseUrl}/users`, {

            headers: {
                'Authorization': `Bearer ${token}`

            },

            method: 'GET'
        })
            .then(res => res.json())
            .then(data => data)
        //TODO: Do something with the retrieved data
    }
    return data;
}

export const createUser = async (data) => {
    fetch(`${BaseUrl}/users/register`, {
        method: 'POST',
        body: JSON.stringify(data)
    })
        .then(res => res.status === 201 ? res.json() : { error: 'Invalid Credentials' })
        .then(res => {
            if (res.error) {
                alert(res.error);
                return;
            }

        })
        .catch(err => alert(err));
}

export const getUserById = (id) => {
    checkLogin();
    const token = localStorage.getItem('token');
    if (token) {
        fetch(`${BaseUrl}/users/${id}`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
            ,
            method: 'GET'
        })
            .then(res => res.json())
            .then(data => console.log(data))
            .catch(err => console.log(err));
    }
    //TODO: Do something with the retrieved data
}

// Get user by role
export const getUserByRole = (role) => {
    const token = localStorage.getItem('token');
    let data;
    if (token) {
        data = fetch(`${BaseUrl}/users/role/${role}`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
            ,
            method: 'GET'
        })
            .then(res => res.json())
            .then(data => data);
    }
    return data;
}

export const getResources = () => {
    checkLogin();
    const token = localStorage.getItem('token');
    if (token) {
        fetch(`${BaseUrl}/resources`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
            ,
            method: 'GET'
        })
            .then(res => res.json())
            .then(data => console.log(data))
            .catch(err => console.log(err));
    }
}

export const getResource = (id) => {
    checkLogin();
    const token = localStorage.getItem('token');
    if (token) {
        fetch(`${BaseUrl}/resources/${id}`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
            ,
            method: 'GET'
        })
            .then(res => res.json())
            .then(data => console.log(data))
            .catch(err => console.log(err));
    }
}

export const createResource = (resource) => {

    const token = localStorage.getItem('token');
    let data;
    if (token) {
        data = fetch(`${BaseUrl}/resources`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
            ,
            method: 'POST',
            body: JSON.stringify(resource)
        })
            .then(res => res.json())
            .then(data => data)
    }
    return data;
}


export const getSchools = () => {

    const token = localStorage.getItem('token');
    let data;
    if (token) {
        data = fetch(`${BaseUrl}/schools`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
            ,
            method: 'GET'
        })
            .then(res => res.json()).then(data => data)
    }
    return data;
}

export const getSchool = (id) => {
    checkLogin();
    const token = localStorage.getItem('token');
    if (token) {
        fetch(`${BaseUrl}/schools/${id}`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
            ,
            method: 'GET'
        })
            .then(res => res.json())
            .then(data => console.log(data))
            .catch(err => console.log(err));
    }
}

export const createSchool = (school) => {
    const token = localStorage.getItem('token');
    if (token) {
        fetch(`${BaseUrl}/schools`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
            ,
            method: 'POST',
            body: JSON.stringify(school)
        })
            .then(res => res.json())
            .then(data => console.log(data))
            .catch(err => console.log(err));
    }
}

export const getSubjects = () => {

    const token = localStorage.getItem('token');
    let data;
    if (token) {
        data = fetch(`${BaseUrl}/courses`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
            ,
            method: 'GET'
        })
            .then(res => res.json())
            .then(data => data)
            .catch(err => console.log(err));
    }
    return data;
}

export const getSubject = (id) => {
    checkLogin();
    const token = localStorage.getItem('token');
    if (token) {
        fetch(`${BaseUrl}/courses/${id}`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
            ,
            method: 'GET'
        })
            .then(res => res.json())
            .then(data => console.log(data))
            .catch(err => console.log(err));
    }
}

export const createSubject = (subject) => {
    const token = localStorage.getItem('token');
    if (token) {
        fetch(`${BaseUrl}/courses`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
            ,
            method: 'POST',
            body: JSON.stringify(subject)
        })
            .then(res => res.json())
            .then(data => console.log(data))
            .catch(err => console.log(err));
    }
}


export const getAttendances = (date) => {
    //date must have a format of YYYY-MM-DD

    const token = localStorage.getItem('token');
    let data;
    if (token) {
        data = fetch(`${BaseUrl}/attendance/${date}/all`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
            ,
            method: 'GET'
        })
            .then(res => res.json()).then(data => data)
    }
    return data;
    
}

export const getAttendace = (id, date) => {
    //date must have a format of YYYY-MM-DD

    const token = localStorage.getItem('token');
    if (token) {
        fetch(`${BaseUrl}/attendances/${date}/${id}`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
            ,
            method: 'GET'
        })
            .then(res => res.json())
            .then(data => console.log(data))
            .catch(err => console.log(err));
    }
}