import GlobalService from '../global.service'

export default class FlightService {
  /* @ngInject */
  constructor ($http, server, GlobalService) {
    this.$http = $http
    this.server = server
    this.GlobalService = GlobalService
  }

  getAllFlights () {
    return this.$http
      .get(this.server + 'flights')
      .then((flights) => flights.data)
  }

  getFlight (id) {
    return this.$http
      .get(this.server + 'flights/' + id)
      .then((flight) => flight.data)
  }

}
