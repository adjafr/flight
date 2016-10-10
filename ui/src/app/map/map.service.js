/* @ngInject */
class MapService {
  constructor ($http, $state) {
    this.$http = $http
//    this.apiUrl = apiUrl
    this.server = 'http://localhost:8000'
    this.$state = $state

    this.details = []
  }

  getMarkerByCityName (name) {
    return this.$http
      .get(`${this.server}/location/name`, { params: { name } }) //apiUrl

      .then(result => result.data)
  }

  nameCheck (name) {
      if (name === 'Memphis') {
        return 'Memphis'
      } else if (name === 'CHATTANOOGA') {
        return 'Chattanooga'
      } else if (name === 'KNOXVILLE') {
        return 'Knoxville'
      } else if (name === 'NASHVILLE') {
        return 'Nashville'
      }
    }

}

export default MapService
