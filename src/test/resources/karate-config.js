function () {
    var env = karate.env; // get system property 'karate.env'
    projectID = 1879048400
    mjennerID = 1879048288
    polearyID = 1879049107
    karate.configure('connectTimeout', 6000000);
    karate.configure('readTimeout', 6000000);

    var config = {
        env: env,
        serverUrl : 'https://qa122.aconex.com/',
        password : 'ac0n3x72'
    }

    return config;
}