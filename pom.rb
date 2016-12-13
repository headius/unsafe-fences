project 'unsafe-shim', 'http://maven.apache.org' do

  model_version '4.0.0'
  id 'com.headius:unsafe-shim:1.0-SNAPSHOT'
  packaging 'jar'

  jar( 'junit:junit:3.8.1',
       :scope => 'test' )

end
