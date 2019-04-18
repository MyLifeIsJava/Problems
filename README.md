# Newton NXT #

### Regression Test ###
Once the Newton NXT app is up and running on an environment, we can run the regression tests.

#### Setup needed for the regression tests ####
We need below LDAP users

| LDAP User | Role | Instances | Description |
| ------ | ------ | ------ | ------ |
| <sub>NEWTON_AUTO_TEST</sub> | <sub>NEWTON_NXT_API_CLIENT</sub> | <sub>NEWTON_AUTO_TEST_INSTANCE, NEWTON_AUTO_DELETE_TEST_INSTANCE, NEWTON_AUTO_ANON_TEST_INSTANCE, NEWTON_AUTO_API_ROLE_TEST_INSTANCE</sub> | <sub>This user is used to test all the APIs</sub>  |
| <sub>NEWTON_AUTO_TEST_NO_API_CLIENT</sub> | - | - | <sub>This user is used to test that API access is not allowed when the user doesn't have the role NEWTON_NXT_API_CLIENT</sub> |
| <sub>NEWTON_AUTO_TEST_NO_INSTANCES</sub> | <sub>NEWTON_NXT_API_CLIENT</sub> | - | <sub>This user is used to test that access on instance is not alowed unless user has the permission for that instance</sub> |

We need the below records in the couchbase database

| Document Id | Content | Description |
| ------ | ------ | ------ |
| <sub>7e5f3277-8efe-46e4-848d-2ab0289e23b4-role</sub> |  <sub>{<br>  "personId": "7e5f3277-8efe-46e4-848d-2ab0289e23b4",<br>  "instances": [<br>    "NEWTON_AUTO_TEST_INSTANCE",<br>    "NEWTON_AUTO_DELETE_TEST_INSTANCE",<br>    "NEWTON_AUTO_API_ROLE_TEST_INSTANCE",<br>    "NEWTON_AUTO_ANON_TEST_INSTANCE"<br>  ],<br>  "roles": [<br>    "ADMIN"<br>  ],<br>  "resourceType": "userRole"<br>}</sub> | <sub>This is the MODERATOR user</sub> |
| <sub>cd2919a2-58a3-4fe6-9d6a-b59310cdae8b-role</sub> | <sub>{<br>  "personId": "cd2919a2-58a3-4fe6-9d6a-b59310cdae8b",<br>  "instances": [<br>    "NEWTON_AUTO_TEST_INSTANCE",<br>    "NEWTON_AUTO_DELETE_TEST_INSTANCE",<br>    "NEWTON_AUTO_API_ROLE_TEST_INSTANCE",<br>    "NEWTON_AUTO_ANON_TEST_INSTANCE"<br>  ],<br>  "roles": [<br>    "SUPERADMIN"<br>  ],<br>  "resourceType": "userRole"<br>}<br></sub> | <sub>This is the SUPERADMIN user</sub> |
| <sub>249c6d75-4082-4125-b639-9d3951312abf-role</sub> | <sub>{<br>  "personId": "249c6d75-4082-4125-b639-9d3951312abf",<br>  "instances": [<br>    "NEWTON_AUTO_API_ROLE_TEST_INSTANCE",<br>  ],<br>  "roles": [<br>    "CUSTOM_ROLE"<br>  ],<br>  "resourceType": "userRole"<br>}</sub> | <sub>This use has CUSTOM_ROLE which is used to test user defined roles for API access</sub> |

We need the below users in Janrain

| Email Id | UUID | Password | Description |
| ------ | ------ | ------ | ------ |
| newton_auto_test_user@newton.com | bb9830a2-c98e-4675-a2bd-5a0913b76e5a | Check with Newton team | This user is used for SELF role |
| newton_auto_test_proxy@newton.com | 093b59ec-c424-4d0b-a2ef-21031651f063 | Check with Newton team | This user is used for PROXY role |
| newton_auto_test_moderator@newton.com | 7e5f3277-8efe-46e4-848d-2ab0289e23b4 | Check with Newton team | Used for MODERATOR user |
| newton_auto_test_superadmin@newton.com | cd2919a2-58a3-4fe6-9d6a-b59310cdae8b | Check with Newton team | Used for SUPERADMIN role |
| newton_auto_test_custom_role@newton.com | 249c6d75-4082-4125-b639-9d3951312abf | Check with Newton team | Used for CUSTOM_ROLE role |
