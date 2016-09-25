import userURL from './user.component.html'

/* @ngInject */
class UserController {
  constructor (userSrvce) {
    var ctrl = this
    ctrl.user
    ctrl.itinerary

    ctrl.searchFlight = function () {
      userSrvce
      .newItinerary(ctrl.user)
    }
  }
}


  export default {
    templateUrl: userURL,
    controller: UserController,
    controllerAs: 'userCtrl'
  }
