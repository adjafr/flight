import templateUrl from '../templates/login.template.html'
import LoginController from './login.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: LoginController,
  bindings: {
    entities: '<',
    allUsers: '<'
  }
}
