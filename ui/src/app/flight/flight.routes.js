export default function route ($stateProvider) {
  $stateProvider
    .state('flights', {
      url: '/flights',
      component: 'appFlight',
      resolve: {
        entities: function (flightService) {
          return flightService.getAllFlights()
        }
      }
    })
    .state('flightDetail', {
      url: '/flightDetail',
      component: 'appFlightDetail',
      resolve: {
        entity: function (flightService, $stateParams) {
          return flightService.getFlight($stateParams.id)
        }
      }
    })
}
