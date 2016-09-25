import templateUrl from '../templates/forgotpassword-detail.template.html'
import ForgotPasswordController from './forgotpassword.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: ForgotPasswordController,
  bindings: {
    entity: '<'
  }
}
