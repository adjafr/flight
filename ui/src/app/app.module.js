// import angular from 'angular'
// import uiRouter from 'angular-ui-router'
// import angularMaterial from 'angular-material'

import flightMap from './map/map.module'
// import apiUrl from './api.url'
import appComponent from './app.component.js'
import routes from './app.routes'
// import homeApp from './app/home/home.module'
import appFlight from './flight/flight.module'
import appUser from './user/user.module'
import register from './register/register.module'
import login from './login/login.module'
import bcrypt from 'bcryptjs'
import forgotpassword from './forgotpassword/forgotpassword.module'
import GlobalService from './global.service'

export default
// /* @ngInject */
  angular
    .module('flight', ['ngAria', 'ngAnimate', 'ngMaterial', 'ngMessages', 'ui.router', flightMap, appUser, appFlight, register, login, , forgotpassword])
    .constant('server', 'http://localhost:8000/')   //'apiUrl', apiUrl
    .component('flightApp', appComponent)
    .service('GlobalService', GlobalService)
    .config(routes)
    .name


    //
