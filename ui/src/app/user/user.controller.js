import GlobalService from '../global.service'

export default class UserController {
  /* @ngInject */
  constructor ($scope, $timeout, GlobalService, UserDetailService, $state, $map, $interval) {
    this.name = 'Users'
    this.link = 'userDetail'
    this.glyph = 'user'
    this.GlobalService = 'GlobalService'
    this.flight
    this.itinerary
    this.listOfFlights
    this.$map = $map
    this.$interval = $interval
    this.$state = $state


    this.findFlight = function () {
      UserDetailService.searchFlights(this.flight).then(function(promise){
        $scope.flights=promise.data
          console.dir($scope.flights)
          $scope.flightList = [];
          for(var i=0; i < promise.data.length; i++) {
            $scope.mapdata = promise.data[i];
            $scope.flightList.push($scope.mapdata);
          }
          console.log($scope.flightList);

      })

      $scope.timer = $timeout(function() {
        findFlight();
      }, 6000)

      $scope.$on('$destroy', function() {
        $timeout.cancel($scope.timer)
      })

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
