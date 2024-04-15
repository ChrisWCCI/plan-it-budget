import React from "react";
import * as FaIcons from "react-icons/fa6";

export const SidebarData = [
  {
    title: "Home",
    path: "/",
    icon: <FaIcons.FaHouse />,
    cName: "nav-text",
  },
  {
    title: "Goals",
    path: "/goals",
    icon: <FaIcons.FaMoneyBillTrendUp />,
    cName: "nav-text",
  },
  {
    title: "Debt Burn Down",
    path: "/debtBurnDown",
    icon: <FaIcons.FaFireFlameCurved />,
    cName: "nav-text",
  },
  {
    title: "Retirement",
    path: "/retirement",
    icon: <FaIcons.FaMountainSun />,
    cName: "nav-text",
  },
  {
    title: "Resources",
    path: "/resources",
    icon: <FaIcons.FaSackDollar />,
    cName: "nav-text",
  },
  {
    title: "About",
    path: "/about",
    icon: <FaIcons.FaUsersViewfinder />,
    cName: "nav-text",
  },
];
