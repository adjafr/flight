import templateUrl from '../templates/users.template.html'
import UserController from './user.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: UserController,
  bindings: {
    entities: '<'
  }
}