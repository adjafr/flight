export default
function route ($stateProvider) {
  /* @ngInject */

  $stateProvider
  .state('map', {
    url: '/map',
    template: '<flight-map></flight-map>',
    title: 'Flight Map'
  })
}
