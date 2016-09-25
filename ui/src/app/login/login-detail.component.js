import templateUrl from '../templates/login-detail.template.html'
import LoginController from './login.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: LoginController,
  bindings: {
    entity: '<'
  }
}