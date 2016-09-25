import templateUrl from './templates/home.template.html'

export default {
  templateUrl,
  controllerAs: 'homeController',
  controller: class HomeController {}
}


// import templateUrl from './templates/home.template.html'    //'./app.component.html'
//
// /* @ngInject */
// class AppController {
//   constructor ($log) {
//     $log.debug('AppController is a go.')
//   }
// }
//
// export default {
//   templateUrl,
//   controller: 'AppController',
//   controllerAs: '$appCtrl'
// }

// import templateUrl from './app.component.html'
//
// /* @ngInject */
// class AppController {
//  constructor ($log) {
//    $log.debug('AppController is a go.')
//  }
// }
//
// export default {
//  templateUrl,
//  controller: AppController,
//  controllerAs: '$appCtrl'
// }
