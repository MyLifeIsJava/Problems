# Newton NXT #

### Regression Test ###
Once the Newton NXT app is up and running on an environment, we can run the regression tests.

#### Setup needed for the regression tests ####
We need below LDAP users

| LDAP User | Role | Instances | Description |
| ------ | ------ | ------ | ------ |
| NEWTON_AUTO_TEST | NEWTON_NXT_API_CLIENT | NEWTON_AUTO_TEST_INSTANCE, NEWTON_AUTO_DELETE_TEST_INSTANCE, NEWTON_AUTO_ANON_TEST_INSTANCE, NEWTON_AUTO_API_ROLE_TEST_INSTANCE | This user is used to test all the APIs  |
| NEWTON_AUTO_TEST_NO_API_CLIENT | - | - | This user is used to test that API access is not allowed when the user doesn't have the role NEWTON_NXT_API_CLIENT |
| NEWTON_AUTO_TEST_NO_INSTANCES | NEWTON_NXT_API_CLIENT | - | This user is used to test that access on instance is not alowed unless user has the permission for that instance |

We need the below records in the couchbase database

| Document Id | Content | Description |
| ------ | ------ | ------ |
| 7e5f3277-8efe-46e4-848d-2ab0289e23b4-role |  {<br>  "personId": "7e5f3277-8efe-46e4-848d-2ab0289e23b4",<br>  "instances": [<br>    "NEWTON_AUTO_TEST_INSTANCE",<br>    "NEWTON_AUTO_DELETE_TEST_INSTANCE",<br>    "NEWTON_AUTO_API_ROLE_TEST_INSTANCE",<br>    "NEWTON_AUTO_ANON_TEST_INSTANCE"<br>  ],<br>  "roles": [<br>    "ADMIN"<br>  ],<br>  "resourceType": "userRole"<br>}  | This is the MODERATOR user |
| cd2919a2-58a3-4fe6-9d6a-b59310cdae8b-role | {<br>  "personId": "cd2919a2-58a3-4fe6-9d6a-b59310cdae8b",<br>  "instances": [<br>    "NEWTON_AUTO_TEST_INSTANCE",<br>    "NEWTON_AUTO_DELETE_TEST_INSTANCE",<br>    "NEWTON_AUTO_API_ROLE_TEST_INSTANCE",<br>    "NEWTON_AUTO_ANON_TEST_INSTANCE"<br>  ],<br>  "roles": [<br>    "SUPERADMIN"<br>  ],<br>  "resourceType": "userRole"<br>}<br> | This is the SUPERADMIN user |
| 249c6d75-4082-4125-b639-9d3951312abf-role | {<br>  "personId": "249c6d75-4082-4125-b639-9d3951312abf",<br>  "instances": [<br>    "NEWTON_AUTO_API_ROLE_TEST_INSTANCE",<br>    "NEWTON_AUTO_ANON_TEST_INSTANCE"<br>  ],<br>  "roles": [<br>    "CUSTOM_ROLE"<br>  ],<br>  "resourceType": "userRole"<br>} | This use has CUSTOM_ROLE which is used to test user defined roles for API access |

