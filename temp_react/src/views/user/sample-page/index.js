// material-ui
import { Typography } from '@mui/material';
import { useEffect, useState } from 'react';
// material-ui
import { Grid } from '@mui/material';
import { gridSpacing } from 'store/constant';

import UserService from 'services/sample/UserService';
import ServiceCaller from 'services/ServiceCaller';
import UserLayout from 'layout/UserLayout';
import UserList from './UserList';
import TableComponent from 'ui-component/TableComponent';

// ==============================|| SAMPLE PAGE ||============================== //

const SamplePage = () => {
    const [data, setData] = useState([]);
    const [isSuccess, setSuccess] = useState(false);
    const getData = () => {
        let serviceCaller = new ServiceCaller();
        UserService.get(serviceCaller, '', (res) => {
            setSuccess(true);
            setData(res.products);
        }, (err) => {
            setSuccess(false);
            console.log(err);
        })
      }
    
      useEffect(() => {
       // getData()
      }, []);    

    return(
        
        <Grid container spacing={gridSpacing}>
            <Grid item xs={12}>
             <UserList />
            </Grid>
        </Grid> 
    )
};

export default SamplePage;
