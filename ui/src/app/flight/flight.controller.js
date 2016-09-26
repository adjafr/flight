import GlobalService from '../global.service'

export default class FlightController {
  /* @ngInject */
  constructor (GlobalService, $interval, $state) {
    this.name = 'Flights'
    this.link = 'flightDetail'
    this.glyph = 'flight'
    this.GlobalService = 'GlobalService'
    if (this.entity) {
      this.info = {
        Flight: this.entity.flight
        //User: this.entity.user
      }
//      this.setInfo = {
//        Users: this.entity.users,
//        Flights: this.entity.flights
//      }
    }
      this.intervalPromise = $interval(function() {
        $state.reload();
      }, 5000)


  }

  getLink (name) {
    if (name === 'Flight') {
      return 'flightDetail'
    } else if (name === 'Flight') {
      return 'flightDetail'
    }
  }

  getGlyph (name) {
    if (name === 'Flight') {
      return 'flag'
    } else if (name === 'Flight') {
      return 'home'
    }
  }




}
