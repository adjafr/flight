import templateUrl from './home.component.html'
import homeController from './home.controller'


export default {
  templateUrl: templateUrl,
  controller: homeController,
  controllerAs: 'homeCtrl',
  bindings: {
    allFlights: '<'
  }

}
