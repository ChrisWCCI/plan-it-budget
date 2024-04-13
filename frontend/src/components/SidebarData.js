import React from 'react';
import { FaHouse, FaMoneyBillTrendUp, FaFireFlameCurved, FaMountainSun, FaSackDollar, FaUsersViewfinder  } from "react-icons/fa6";

export const SidebarData =[
    
{
    title: 'Home',
    path: '/',
    icon: <FaHouse />,
    cName: 'nav-text',
},
{
    title: 'Goals',
    path: '/Goals',
    icon: <FaMoneyBillTrendUp />,
    cName: 'nav-text',
},
{
    title: 'Burn Down',
    path: '/Burn Down',
    icon: <FaFireFlameCurved />,
    cName: 'nav-text',
},{
    title: 'Retirement',
    path: '/Retirement',
    icon: <FaMountainSun />,
    cName: 'nav-text',
},{
    title: 'Resources',
    path: '/Resources',
    icon: <FaSackDollar />,
    cName: 'nav-text',
},{
    title: 'About',
    path: '/About',
    icon: <FaUsersViewfinder />,
    cName: 'nav-text',
},

]