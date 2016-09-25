import templateUrl from '../templates/forgotpassword.template.html'
import ForgotPasswordController from './forgotpassword.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: ForgotPasswordController,
  bindings: {
    entities: '<'
  }
}