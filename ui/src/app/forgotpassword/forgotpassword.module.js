import forgotpassword from './forgotpassword.component'
import forgotpasswordDetail from './forgotpassword-detail.component'

import ForgotPasswordService from './forgotpassword.service'

import routes from './forgotpassword.routes'

export default angular.module('app.forgotpassword', [])
  .service('forgotpasswordService', ForgotPasswordService)
  .component('appForgotPassword', forgotpassword)
  .component('appForgotPasswordDetail', forgotpasswordDetail)
  .config(routes)
  .name