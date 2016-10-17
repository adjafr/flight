import GlobalService from '../global.service'

export default class FlightController {
  /* @ngInject */
  constructor (GlobalService, $timeout, $state, $scope) {
    this.name = 'Flights'
    this.link = 'flightDetail'
    this.glyph = 'flight'
    this.GlobalService = 'GlobalService'
    if (this.entity) {
      this.info = {
        Flight: this.entity.flight
      }
    }

      $scope.pageTimer = $timeout(function() {
        $state.reload();
      }, 60000)

      $scope.$on('$destroy', function() {
        $timeout.cancel($scope.pageTimer)
      })
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
