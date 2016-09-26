// import angular from 'angular'
// import uiRouter from 'angular-ui-router'
// import angularMaterial from 'angular-material'
import bcrypt from 'bcryptjs'

import flightMap from './map/map.module'
// import apiUrl from './api.url'
import flight from './app.component.js' //appComponent //flightApp
import routes from './app.routes'
import appUser from './user/user.module'
// import homeApp from './app/home/home.module'
import appFlight from './flight/flight.module'

import login from './login/login.module'
import register from './register/register.module'
import forgotpassword from './forgotpassword/forgotpassword.module'
import GlobalService from './global.service'




export default
// /* @ngInject */
  angular
    .module('flight', ['ngAria', 'ngAnimate', 'ngMaterial', 'ngMessages', 'ui.router', flightMap, appUser, appFlight, login, register, forgotpassword])
    .constant('server', 'http://localhost:8000/')   //'apiUrl', apiUrl
    .component('flight', flight)
    .service('GlobalService', GlobalService)
    .config(routes)
    .name


    //
