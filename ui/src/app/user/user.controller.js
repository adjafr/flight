import GlobalService from '../global.service'

export default class UserController {
  /* @ngInject */
  constructor ($scope, $timeout, GlobalService, userService, UserDetailService, $state, $map, $interval, $stateParams) {
    var ctrl = this


    this.name = 'Users'
    this.link = 'userDetail'
    this.glyph = 'user'
    this.GlobalService = 'GlobalService'
    this.userService = 'userService'
    this.flight
    this.itinerary
    this.listOfFlights
    this.$map = $map
    this.$interval = $interval
    this.$state = $state


    this.currentUser = function () {
         UserDetailService.getUser($stateParams.id).then(function (user) {
           ctrl.user = user.data
           console.log("I am called");
         })
       }



    this.findFlight = function () {
      UserDetailService.searchFlights(this.flight).then(function(promise){
        $scope.flightItinerary = promise.data; 
//         for(var j =0; j < promise.data.length; j++) {
//         $scope.flights=promise.data[j].savedFlight;
//           console.dir($scope.flights)
//           $scope.flightList = [];
//           for(var i=0; i < promise.data[j].savedFlight.length; i++) {
//             $scope.mapdata = promise.data[j].savedFlight[i];
//             $scope.flightList.push($scope.mapdata);
//
//           }
//           console.log($scope.flightList);
// }
      })

      $scope.pageTimer = $timeout(function() {  //timeout
      ctrl.findFlight();    //findFlight();  //$state.reload();
      }, 6000)

        $scope.$on('$destroy', function() {
        $timeout.cancel($scope.pageTimer)
      })

      // $scope.pageTimer = $interval(function() {  //timeout
      // this.findFlight();    //findFlight();  //$state.reload();
      // }, 6000)
      //
      // this.findFlight();


    }

    // this.intervalPromise = $interval(function() {
    //   angular.element(document.querySelector('#searchFlightsButton')).triggerHandler('click');
    // }, 5000)

    this.saveFlights = function(flightList) {
  console.log("I am falled");
    UserDetailService.saveFlights(flightList, this.$state.params.id).then(function(promise){
       console.dir(promise.data)
    });
    }

    this.getAllItinerariesForUser = function () {
      UserDetailService.getAllItinerariesForUser(this.$state.params.id).then(function(promise){
        $scope.itineraries = promise.data
        console.dir(promise.data)
      })
    }


    this.mapSelectedItinerary = function (b) {
        console.log("I am called")
        console.log(b)
        this.$map.details = b.savedFlight
        this.$map.itinerary = b
        this.$state.go('map')
        console.log("controller map")

    }


    // this.intervalPromise = $interval(function() {
    //   $state.reload();
    // }, 6000)




    var bcrypt = require('bcryptjs');

    if (this.entity) {
      this.info = {
        User: this.entity.user,
        // Tweet: this.entity.tweet
      }
      // this.setInfo = {
      //   Tweets: this.entity.tweets,
      //   Tweets: this.entity.tweets
      // }
    }
  }

  getLink (name) {
    if (name === 'User') {
      return 'userDetail'
    } else if (name === 'Tweet') {
      return 'tweetDetail'
    }
  }

  getGlyph (name) {
    if (name === 'User') {
      return 'flag'
    } else if (name === 'Tweet') {
      return 'home'
    }
  }







}
