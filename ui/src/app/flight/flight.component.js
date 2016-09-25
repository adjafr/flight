import templateUrl from '../templates/flight.template.html'
import FlightController from './flight.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: FlightController,
  bindings: {
    entities: '<'
  }
}