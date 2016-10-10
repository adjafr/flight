import templateUrl from '../templates/user-detail.template.html'
import UserController from './user.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: UserController,
  bindings: {
    entity: '<'
  }
}
