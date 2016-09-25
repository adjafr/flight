import GlobalService from '../global.service'
import flight from './flight.component'
import flightDetail from './flight-detail.component'

import FlightService from './flight.service'

import routes from './flight.routes'

export default angular.module('app.flight', [])
  .service('flightService', FlightService)
  .service('GlobalService', GlobalService)
  .component('appFlight', flight)
  .component('appFlightDetail', flightDetail)
  .config(routes)
  .name
