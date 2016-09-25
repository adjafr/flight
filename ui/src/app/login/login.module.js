import login from './login.component'
import loginDetail from './login-detail.component'

import LoginService from './login.service'

import routes from './login.routes'

export default angular.module('app.login', [])
  .service('loginService', LoginService)
  .component('appLogin', login)
  .component('appLoginDetail', loginDetail)
  .config(routes)
  .name
