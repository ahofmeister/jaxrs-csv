/*
 * Copyright 2014 Benoît Prioux
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.binout.jaxrs.csv;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/persons")
public class PersonResource {

    private static List<Person> repository = new ArrayList<>();

    @GET
    @Produces("text/csv")
    public Response get() {
        return Response.ok(repository).build();
    }

    @POST
    @Consumes("text/csv")
    public Response post(List<Person> persons) {
        repository.addAll(persons);
        return Response.ok().build();
    }
}
