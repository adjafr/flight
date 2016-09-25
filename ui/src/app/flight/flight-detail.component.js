import templateUrl from '../templates/flight-detail.template.html'
import FlightController from './flight.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: FlightController,
  bindings: {
    entity: '<'
  }
}
