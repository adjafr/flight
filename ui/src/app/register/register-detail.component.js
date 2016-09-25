import templateUrl from '../templates/register-detail.template.html'
import RegisterController from './register.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: RegisterController,
  bindings: {
    entity: '<'
  }
}