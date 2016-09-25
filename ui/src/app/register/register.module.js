import register from './register.component'
import registerDetail from './register-detail.component'

import RegisterService from './register.service'
import routes from './register.routes'

export default angular.module('app.register', [])
  .service('registerService', RegisterService)
  .component('appRegister', register)
  .component('appRegisterDetail', registerDetail)
  .config(routes)
  .name
