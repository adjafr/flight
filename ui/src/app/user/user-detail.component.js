import templateUrl from '../templates/entity-detail.template.html'
import UserController from './user.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: UserController,
  bindings: {
    entity: '<'
  }
}