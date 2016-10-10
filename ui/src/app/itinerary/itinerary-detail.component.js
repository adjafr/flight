import templateUrl from '../templates/user-itinerary.template.html'
import UserController from './itinerary.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: ItineraryController,
  bindings: {
    entity: '<'
  }
}