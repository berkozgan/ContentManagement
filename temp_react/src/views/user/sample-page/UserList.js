import React, { useEffect, useState } from 'react';
import UserService from 'services/sample/UserService';
import ServiceCaller from 'services/ServiceCaller';
import TableComponent from 'ui-component/TableComponent';
import { Grid } from '@mui/material';
import { gridSpacing } from 'store/constant';

const UserList = () => {
    const [users, setUsers] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const serviceCaller = new ServiceCaller();

        UserService.getAllUsers(
            serviceCaller,
            (response) => {
                setUsers(response); // Backend'den gelen kullanıcılar
                setLoading(false);
            },
            (error) => {
                console.error("Error fetching users:", error);
                setLoading(false);
            }
        );
    }, []);
        
            return (
<div>
{loading ? <h5>data is loading</h5>  : <TableComponent users= {users}/>  }
</div>

            ) 
};

export default UserList;
